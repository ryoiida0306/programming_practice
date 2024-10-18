from toHira import hira_convert
from dictionary import dict
import msvcrt

def next_char(hira_text, i):
    next_dict = []
    next_c = []
    best_c = ""
    best_c_length = 0
    char = hira_text[i]
    if i < len(hira_text) - 2:
        char3 = char + hira_text[i+1] + hira_text[i+2]
        if char3 in dict:
            next_dict.append({"char": dict[char3], "length": 3})
            for j in range(len(dict[char3])):
                next_c.append(dict[char3].iloc[j])
                if len(dict[char3].iloc[j]) > len(best_c):
                    best_c = dict[char3].iloc[j]
                    best_c_length = 3
    if i < len(hira_text) - 1:
        char2 = char + hira_text[i+1]
        if char2 in dict:
            next_dict.append({"char": dict[char2], "length": 2})
            for j in range(len(dict[char2])):
                next_c.append(dict[char2].iloc[j])
                if best_c == "" and len(dict[char2].iloc[j]) > len(best_c):
                    best_c = dict[char2].iloc[j]
                    best_c_length = 2
    if char in dict:
        next_dict.append({"char": dict[char], "length": 1})
        for j in range(len(dict[char])):
            next_c.append(dict[char].iloc[j])
            if best_c == "" and len(dict[char].iloc[j]) > len(best_c):
                best_c = dict[char].iloc[j]
                best_c_length = 1

    return next_dict, next_c, best_c, best_c_length

def main(): 
    text = "どんな言葉でもABCでも基本的には1行目には品詞が、2行目には原形が、9行目には品詞細分類が、10行目には活用形が、11行目には活用型が、12行目には原形が出力されます。"
    hira_text = hira_convert(text)

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

    print("Original text: ", text)
    print("Hiragana text: ", hira_text)
    print("Best text: ", best_text)

    type_text = ""
    print_text = ""
    now_hira_idx = 0
    while now_hira_idx < len(hira_text):
        next_dict, next_c, best_c, best_c_length = next_char(hira_text, now_hira_idx)
        now_input_char = ""
        while True:
            in_c = msvcrt.getch().decode('utf-8')
            if in_c == "`":
                print("Quit")
                return 0
            
            # now_best_list = []
            # hira_idx = now_hira_idx
            # while i < len(hira_text[hira_idx:]):
            #     next_dict, next_c, best_c, best_c_length = next_char(hira_text, hira_idx)
            #     now_best_list.append(best_c)
            #     hira_idx += best_c_length
            # print_text = type_text + "".join(now_best_list)

            # print([s[:len(now_input_char + in_c)] for s in next_c]) #最初の一文字
            # print(next_c)
            if (now_input_char + in_c) in [s[:len(now_input_char + in_c)] for s in next_c]:
                now_input_char += in_c
                type_text += in_c
                next_c = [s for s in next_c if s[:len(now_input_char)] == now_input_char]
                print("原文:" , text)
                print("ひらがな",hira_text)
                # print(print_text)
                # print(best_text)
                print(type_text)
                # print(next_c)
                if now_input_char in next_c:
                    # print(next_dict)
                    leng = None
                    idx = 0
                    while idx < 10 :
                        if leng != None: break
                        leng = next((d for d in next_dict if d["char"].values[idx] == now_input_char), None)
                        idx += 1
                    now_hira_idx += leng["length"]
                    # print(leng)
                    break
        



if __name__ == "__main__":
    main()