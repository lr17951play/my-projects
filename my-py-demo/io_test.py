import os

age = int(input("请输入你家狗狗的年龄: "))

if age < 0:
    print("你是在逗我吧!")
elif age == 1:
    print("相当于 14 岁的人。")
elif age == 2:
    print("相当于 22 岁的人。")
elif age > 2:
    human = 22 + (age - 2) * 5
    print("对应人类年龄: ", human)

# 退出提示
input("点击 enter 键退出，测试File")

try:
    with open("C:/Users/Z0040FRJ/Desktop/history/others/ItemController.java", encoding="UTF-8") as fi:
        print(fi.name)
        fr = fi.read()
except Exception as ex:
    print("error happens" + str(ex))
else:
    print(fr)
finally:
    print("----------------------------------------------> finally executed")

os.chdir("C:/Users/Z0040FRJ/Desktop/history/")
if os.path.exists("lalala"):
    pass
else:
    os.mkdir("lalala")
os.chdir("lalala")

if os.path.exists("foo.txt"):
    os.remove("foo.txt")
else:
    pass

with open("foo.txt", "w") as fo:
    fo.write("www.runoob.com!\nVery good site!\n" + fr)


def delete():

    flag = input("是否删除生成的文件和目录？ y/n")

    if flag == "y":
        os.remove("foo.txt")
        os.chdir("C:/Users/Z0040FRJ/Desktop/history/")
        os.rmdir("lalala")  # must be empty
        print("file deleted!")
    elif flag == "n":
        pass
    else:
        print("非法标识，请重新输入")
        delete()


delete()
