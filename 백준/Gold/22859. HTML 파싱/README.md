# [Gold III] HTML 파싱 - 22859 

[문제 링크](https://www.acmicpc.net/problem/22859) 

### 성능 요약

메모리: 39004 KB, 시간: 172 ms

### 분류

구현, 파싱, 정규 표현식, 문자열

### 제출 일자

2024년 2월 23일 05:43:28

### 문제 설명

<p>웹 크롤링을 하여 HTML을 가공하는 프로그램을 만들려고 한다. </p>

<p>HTML은 아래와 같이 구성되어있다. (문제 일반화를 위해 실제 HTML 소스 코드 및 태그가 실제 존재하는 것과 다를 수 있다.)</p>

<pre><main>
    <div title="title_name_1">
        <p>paragraph 1</p>
        <p>paragraph 2 <i>Italic Tag</i> <br > </p>
        <p>paragraph 3 <b>Bold Tag</b> end.</p>
    </div>
    <div title="title_name_2">
        <p>paragraph 4</p>
        <p>paragraph 5 <i>Italic Tag 2</i> <br > end.</p>
    </div>
</main>
</pre>

<p>HTML에는 여는 태그 <code><main></code> 로 시작하여 닫는 태그 <code></main></code> 로 <strong>항상</strong> 끝나고, <code><div></code>, <code></div></code> 사이에 하나의 문단이 존재하고, <code><p>,</code> <code></p></code> 사이에 하나의 문장이 존재한다. <code><p></code>, <code></p></code> 사이에는 main 태그, div 태그, p 태그를 제외한 다른 태그들이 존재할 수도 있다. </p>

<p>위 예시에서 title_name_1, title_name_2 부분은 div 태그 안에 있는 각 문단의 제목이다.</p>

<p>HTML 파싱을 아래와 같이 하려고 한다.<br>
제목1은 위 예시에서 title_name_1에 해당하고, 제목2는 title_name_2에 해당한다. 문장 1 ~ 3은 위 예시에서 3번째 줄부터 5번째 줄을 파싱한 결과에 해당하고, 문장 4 ~ 5는 8번째 줄과 9번째 줄을 파싱한 결과에 해당한다.</p>

<p>첫 번째 줄에는 먼저 "title : "을 출력하고 그 옆에 문단의 제목을 출력한다. 그 아래 줄은 p 태그에 안에 있는 문장마다 한 줄씩 출력한다. 하나의 문단을 출력했다면 새로운 문단을 이와 같은 방식으로 출력한다.</p>

<pre>title : 제목1
문장1
문장2
문장3
title : 제목2
문장4
문장5
</pre>

<p><code><p></code>, <code></p></code> 사이에 있는 부분에 대한 파싱은 아래의 순서대로 진행한다.</p>

<ol>
	<li>p 태그 안에 있는 문장에서 태그가 있다면 태그를 지운다.<br>
	예를 들어, <code>"<p>paragraph 2 <i>Italic Tag</i> <br > </p>"</code> 에서 <code>p</code> 태그 안에 있는 문장에 있는 태그는 <code><i>, </i>, <br ></code>이 있다.<br>
	해당 태그들을 지우면 다음과 같다. <code>"<p>paragraph 2 Italic Tag  </p>"</code></li>
	<li>p 태그 안에 있는 <strong>문장 시작과 끝에 공백</strong>이 있다면 지운다.</li>
	<li>문장에서 공백(space)이 2개 이상 연속적으로 붙어있다면 이를 하나의 공백으로 바꾼다.<br>
	예를 들어 "a  b"에서는 a와 b사이의 공백의 길이가 2이므로 이를 하나의 공백으로 변경하여 "a b"로 만들어준다.</li>
	<li>마지막으로, 여는 태그 <code><p></code>와 닫는 태그 <code></p></code>를 지운다.</li>
</ol>

<p>아래는 HTML문서를 파싱의 결과를 출력한 것이다.</p>

<pre>title : title_name_1
paragraph 1
paragraph 2 Italic Tag
paragraph 3 Bold Tag end.
title : title_name_2
paragraph 4
paragraph 5 Italic Tag 2 end.
</pre>

<ol>
</ol>

### 입력 

 <p>다음을 보장하는 HTML 문서가 주어진다.</p>

<ol>
	<li>HTML의 시작은 <code><main></code>으로 시작하고 <code></main></code>으로 끝난다. 또한 여는 태그가 있다면 닫는 태그가 항상 쌍으로 존재한다.</li>
	<li><code><main></code>, <code></main></code> 사이에 여러 문단이 있을 수 있으며 문단들을 구분할 때 사용하는 div 태그만 사용된다. 문단의 제목은 항상 알파벳(a-z, A-Z)과 언더바(_), 공백( )으로만 구성되어 있다. <strong>제목의 시작 부분과 끝부분은 공백이 없다.</strong></li>
	<li><code><div></code>, <code></div></code> 사이에는 반드시 문장을 의미하는 <code>p</code> 태그만 존재하고 여는 태그 <code><div></code>의 속성으로는 반드시 title이 존재한다.<br>
	즉, <code><div title="(A)"></code> 와 같이 존재하며, <code>(A)</code> 부분은 문단의 제목이다.</li>
	<li><code><p></code>, <code></p></code> 사이에는 <code>main, div, p</code> 태그를 제외한 다른 태그들이 존재할 수 있으며, 예시에서 <br>와 같이 여는 태그만 존재할 수 있고, 여는 태그와 닫는 태그가 올바른 쌍으로 존재한다. 이때, 올바른 쌍은 아직 닫히지 않는 태그가 있을 때 다른 닫는 태그가 올 수 없다. 예를 들어, <code><b>a<i></b></i></code>는 올바른 쌍이 아니고, <code><b>a<i>b</i></b></code>은 올바른 쌍이다.<br>
	태그를 표현하는 '<', '>'를 제외하고는 항상 알파벳(a-z, A-Z)과 공백(' ')으로만 주어진다.</li>
	<li>태그를 표시하는 '<'와 '>' 사이에는 소문자 알파벳(a-z), 공백(' '), 슬래시('/')로 이루어져 있으며 '/' 같은 경우는 닫는 태그에만 존재한다.</li>
	<li><strong>HTML 문서는 한 줄로 주어진다.</strong> <code><p></code>, <code></p></code> 사이에 존재하는 태그를 제외하고는 태그 사이의 공백이 없다.</li>
</ol>

### 출력 

 <p>HTML 문서를 파싱한 결과를 출력한다.</p>

