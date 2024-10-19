from toHira import hira_convert
from dictionary import dict, all_text_list
import msvcrt
import time
import random

def next_char(hira_text, i):
    next_dict = []
    next_c = []
    best_c = ""
    best_c_length = 0
    char = hira_text[i]
    if i < len(hira_text) - 2:
        char3 = char + hira_text[i+1] + hira_text[i+2]
        if char3 in dict:
            next_dict.append((dict[char3], 3))
            for j in range(len(dict[char3])):
                next_c.append(dict[char3].iloc[j])
                if len(dict[char3].iloc[j]) > len(best_c):
                    best_c = dict[char3].iloc[j]
                    best_c_length = 3
    if i < len(hira_text) - 1:
        char2 = char + hira_text[i+1]
        if char2 in dict:
            next_dict.append((dict[char2], 2))
            for j in range(len(dict[char2])):
                next_c.append(dict[char2].iloc[j])
                if best_c == "" and len(dict[char2].iloc[j]) > len(best_c):
                    best_c = dict[char2].iloc[j]
                    best_c_length = 2
    if char in dict:
        next_dict.append((dict[char], 1))
        for j in range(len(dict[char])):
            next_c.append(dict[char].iloc[j])
            if best_c == "" and len(dict[char].iloc[j]) > len(best_c):
                best_c = dict[char].iloc[j]
                best_c_length = 1

    return next_dict, next_c, best_c, best_c_length

def onetext(text): 
    hira_text = hira_convert(text)
    miss = 0
    best_list = []

    i = 0
    while i < len(hira_text):


        next_dict, next_c, best_c, best_c_length = next_char(hira_text, i)
        best_list.append({"char": best_c, "length": best_c_length})
        i += best_c_length
        # print(next_dict)
        # print("\n\n")
        # print(next_c)
        # print("\n\n")
        # print(best_c)
        # print("\n\n")

    
    best_text = "".join([best_list[i]["char"] for i in range(len(best_list))])

    print()
    print("====================================")
    print(text)
    print(hira_text)
    print()
    print()
    # print("Best text: ", best_text)

    type_text = ""
    print_text = ""
    now_hira_idx = 0
    while now_hira_idx < len(hira_text):
        next_dict, next_c, best_c, best_c_length = next_char(hira_text, now_hira_idx)
        _, next_next_c, _, _ = next_char(hira_text, now_hira_idx)

        now_input_char = ""
        
        # print([s[:len(now_input_char + in_c)] for s in next_c]) #最初の一文字

        if hira_text[now_hira_idx] == "ん" and now_hira_idx + 1 < len(hira_text) and "n" in [s[0] for s in next_next_c] :
            next_c = ["nn", "xn"]
            
        while True:
            in_c = msvcrt.getch().decode('utf-8')
            if in_c == "`":
                print("Quit")
                return False
            


            # now_best_list = []
            # hira_idx = now_hira_idx
            # # print(len(hira_text[(now_hira_idx+1):]))
            # for j in range(len(hira_text[(now_hira_idx+1):])):
            #     next_dict, next_c, best_c, best_c_length = next_char(hira_text, hira_idx)
            #     now_best_list.append(best_c)
            #     hira_idx += best_c_length
            # print(now_best_list)
            # print_text = type_text + "".join(now_best_list)

            # print([s[:len(now_input_char + in_c)] for s in next_c]) #最初の一文字
            # print(next_c)
            if (now_input_char + in_c) in [s[:len(now_input_char + in_c)] for s in next_c]:
                now_input_char += in_c
                type_text += in_c
                next_c = [s for s in next_c if s[:len(now_input_char)] == now_input_char]
                print()
                print("====================================")
                print(text)
                print(hira_text)
                print(hira_text[:(now_hira_idx+1)])
                # print(print_text)
                # print(next_c)
                # print(best_text)
                print(type_text)
                # print(next_dict)
                if now_input_char in next_c:
                    # print(next_dict)
                    leng = None
                    for j in range(len(next_dict)):
                        if now_input_char in next_dict[j][0].values:
                            leng = next_dict[j][1]
                            break
                    now_hira_idx += leng
                    # print(leng)
                    break
            else:
                miss += 1

    return True, len(best_text), miss
        

def main():
    start_time = time.time()
    total_length = 0
    total_miss = 0
    # text_list = [
    #     "牛肉",
    #     "どんな言葉でもABCでも基本的には1行目には品詞が出力されます。",
    #     "日本語の文章を入力してください。",
    #     "これはテストです。",
    # ]
    text_list = all_text_list


    # text_listをランダムに並び変える
    random.shuffle(text_list)


    for text in text_list:
        break_flag, text_length, miss = onetext(text)
        total_length += text_length
        total_miss += miss
        if not break_flag:
            break
        if total_length > 300:
            break

    print("====================================")
    print("result")
    print("Time: ", time.time() - start_time)
    print("Total miss: ", total_miss)
    print("type speed: ", total_length / (time.time() - start_time))
    print("miss rate: ", total_miss / total_length)
    print("score: ", total_length / (time.time() - start_time) - 3*total_miss / total_length)

    rank_list = [
        {"name": "A", "score": 7},
        {"name": "B", "score": 6},
        {"name": "C", "score": 5},
        {"name": "D", "score": 4},
        {"name": "E", "score": 3},
        {"name": "F", "score": 2},
        {"name": "G", "score": 1},
    ]

    print("rank: ", [r["name"] for r in rank_list if r["score"] < total_length / (time.time() - start_time) - total_miss / total_length][0])

if __name__ == "__main__":
    main()