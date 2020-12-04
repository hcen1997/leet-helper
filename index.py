import math
import os
import webbrowser

int_list = '[308, 332, 279, 360, 333, 577, 437, 255, 469, 115, 148, 347, 328, 463, 228, 41, 552, 89, 462, 190, 111, 524, 138, 589, 211, 191, 271, 547, 560, 481, 286, 502, 466, 326, 574, 407, 260, 600, 306, 314, 137, 482, 493, 163, 231, 350, 507, 43, 365, 475, 96, 495, 464, 213, 161, 451, 583, 162, 491, 335, 186, 249, 546, 275, 233, 530, 295, 39, 511, 66, 442, 285, 338, 460, 83, 252, 487, 393, 25, 143, 598, 485, 515, 263, 373, 158, 542, 31, 322, 149, 257, 477, 548, 125, 24, 105, 400, 498, 7]'

int_list = eval(int_list)

list.sort(int_list)

remain_list = [7, 24, 25, 31, 39, 41, 43, 66, 83, 89, 96, 105, 111, 115, 125, 137, 138, 143, 148, 149, 158, 161, 162,
               163, 186, 190, 191, 211, 213, 228, 231, 233, 249, 252, 255, 257, 260, 263, 271, 275, 279, 285, 286, 295,
               306, 308, 314, 322, 326, 328, 332, 333, 335, 338, 347, 350, 360, 365, 373, 393, 400, 407, 437, 442, 451,
               460, 462, 463, 464, 466, 469, 475, 477, 481, 482, 485, 487, 491, 493, 495, 498, 502, 507, 511, 515, 524,
               530, 542, 546, 547, 548, 552, 560, 574, 577, 583, 589, 598, 600]


# [7, 24, 25, 31, 39, 41, 43, 66, 83, 89, 96, 105, 111, 115, 125, 137, 138, 143, 148, 149, 158, 161, 162, 163, 186, 190, 191, 211, 213, 228, 231, 233, 249, 252, 255, 257, 260, 263, 271, 275, 279, 285, 286, 295, 306, 308, 314, 322, 326, 328, 332, 333, 335, 338, 347, 350, 360, 365, 373, 393, 400, 407, 437, 442, 451, 460, 462, 463, 464, 466, 469, 475, 477, 481, 482, 485, 487, 491, 493, 495, 498, 502, 507, 511, 515, 524, 530, 542, 546, 547, 548, 552, 560, 574, 577, 583, 589, 598, 600]
# 写入一个程序 这个程序有几个功能
# 记录所有需要做的序号
# 删除已经做过的序号
# 统计所有剩余的

def limit80(dd):
    content = ''
    ma = math.ceil(len(dd) / 10)
    for i in range(ma):
        content = content + str(dd[i * 10:i * 10 + 10]) + '\n'
    content = content[0:-1]
    return content


def all():
    print(limit80(int_list))
    # print(int_list)


def store():
    # 第一个是 all
    # 第二个是 remain
    with open('./store.txt', 'w') as f:
        f.write(str(int_list) + '\n')
        f.write(str(remain_list) + '\n')


def get():
    with open('./store.txt', 'r') as f:
        int_list = eval(f.readline()[:-1])
        remain_list = eval(f.readline()[:-1])


def d1():
    # shift from remain
    remain_list.pop(0)
    store()
    get()


def u1():
    target = len(int_list) - len(remain_list) - 1
    remain_list.insert(0, int_list[target])
    store()
    get()


def remain():
    print(limit80(remain_list))


def show():
    # show worked/all
    il = len(int_list)
    rl = len(remain_list)
    print('已完成/总计:  ' + str(il - rl) + '/' + str(il))


def help():
    print("""command = ['help','all','d1','u1','remain','show','exit']""")


def handelCommand(enter):
    eval(enter + '()')


def get_english_name(id):
    with open('./all_index.js','r') as f:
        dd = f.read()
        import  json
        jj = json.loads(dd)
        name = jj['stat_status_pairs'][1312 - id]['stat']['question__title_slug']
        return name

def leet():
    leet_url = 'https://leetcode-cn.com/'
    prob_url = 'https://leetcode-cn.com/problems/'
    all_url = 'https://leetcode-cn.com/api/problems/all/'
    target = prob_url+get_english_name(remain_list[0])+'/'
    webbrowser.open(target)


if not os.path.exists('./store.txt'):
    store()

with open('./store.txt', 'r') as f:
    f.readline()
    remain_list = eval(f.readline()[:-1])
while True:
    enter = input("> ")
    command = ['help', 'all', 'remain', 'd1', 'u1', 'show', 'exit', 'leet']
    if enter in command:
        handelCommand(enter)
    else:
        # 这样处理很不好,不人性化,人输入这些东西应该是为了让人使用,而不是提示就完了
        print('error command: ' + enter + ' command not found')
        help()
        print('maybe you can teach me by send email to panzetaoyx@qq.com')
