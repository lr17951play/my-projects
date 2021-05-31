import turtle
import random as rad
import math as mat


def tree(n, l):
    # 下笔
    tur.pd()
    # 阴影效果
    t = mat.cos(mat.radians(tur.heading() + 45)) / 8 + 0.25
    tur.pencolor(t, t, t)
    tur.pensize(n / 3)
    # 画树枝
    tur.forward(l)

    if n > 0:
        # 右分支偏转角度
        b = rad.random() * 15 + 10
        # 左分支偏转角度
        c = rad.random() * 15 + 10
        # 下一个分支的长度
        d = l*(rad.random() * 0.25 + 0.7)
        # 右转一定角度,画右分支
        tur.right(b)
        tree(n - 1, d)
        # 左转一定角度，画左分支
        tur.left(b + c)
        tree(n - 1, d)
        # 转回来
        tur.right(c)
    else:
        # 画叶子
        tur.right(90)
        n = mat.cos(mat.radians(tur.heading() - 45)) / 4 + 0.5
        tur.pencolor(n, n * 0.8, n * 0.8)
        tur.circle(3)
        tur.left(90)
        # 添加0.3倍的飘落叶子
        if rad.random() > 0.7:
            tur.pu()
            # 飘落
            t = tur.heading()
            an = -40 + rad.random() * 40
            tur.setheading(an)
            dis = int(800 * rad.random() * 0.5 + 400 * rad.random() * 0.3 + 200 * rad.random() * 0.2)
            tur.forward(dis)
            tur.setheading(t)
            # 画叶子
            tur.pd()
            tur.right(90)
            n = mat.cos(mat.radians(tur.heading() - 45)) / 4 + 0.5
            tur.pencolor(n * 0.5 + 0.5, 0.4 + n * 0.4, 0.4 + n * 0.4)
            tur.circle(2)
            tur.left(90)
            tur.pu()
            # 返回
            t = tur.heading()
            tur.setheading(an)
            tur.backward(dis)
            tur.setheading(t)
    tur.pu()
    # 退回
    tur.backward(l)


tur = turtle.Turtle()
scr = turtle.Screen()
# 背景色
scr.bgcolor(0.5, 0.5, 0.5)
# 隐藏turtle
tur.ht()
# 速度 1-10渐进，0 最快
tur.speed(0)
scr.tracer(0, 0)
# 抬笔
tur.pu()
tur.backward(100)
# 左转90度
tur.left(90)
# 抬笔
tur.pu()
# 后退300
tur.backward(300)
# 递归7层
tree(12, 100)
turtle.done()
