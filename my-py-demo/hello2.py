if __name__ == "__main__":
    print("This is running independent")
else:
    print("This is import")


def reverseWords(input):
    # 通过空格将字符串分隔符，把各个单词分隔为列表
    inputWords = input.split(" ")

    # 翻转字符串
    # 假设列表 list = [1,2,3,4],
    # list[0]=1, list[1]=2 ，而 -1 表示最后一个元素 list[-1]=4 ( 与 list[3]=4 一样)
    # inputWords[-1::-1] 有三个参数
    # 第一个参数 -1 表示最后一个元素
    # 第二个参数为空，表示移动到列表末尾
    # 第三个参数为步长，-1 表示逆向
    inputWords = inputWords[-1::-1]

    # 重新组合字符串
    output = ' '.join(inputWords)

    return output


suum = lambda arg1, arg2: arg1 + arg2;
print(suum(13, 17))


def funx(x):
    """
    Function for test inner function
    :param x: number
    :return: funy
    """

    def funy(y):
        """
        Function for test inner Function funy
        :param y: number
        :return: x * y
        """
        return x * y

    return funy  # return funy返回的是一个对象，可理解为funx是funy的一个对象


print(funx(10)(5))
print(funx.__doc__)

foo = [2, 18, 9, 22, 17, 24, 8, 12, 27]

print(list(filter(lambda x: x % 3 == 0, foo)))
print([x for x in foo if x % 3 == 0])
