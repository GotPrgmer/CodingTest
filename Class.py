class Person2:
    def __init__(self, user, age):
        self.user = user
        self.age = age

    def say_hello2(self, to_name):
        print("안녕! " + to_name + "나는 "+ self.user + "이야")

    def introduce(self, to_name):
        print("안녕! " + to_name + "나는 " + self.user + " 그리고" + str(self.age) + " 살이야")

yonga = Person2("영아", 20)
sua = Person2("수아",20)
youjin = Person2("유진", 35)

yonga.say_hello2("영희")
sua.say_hello2("보람")
youjin.introduce("진수")