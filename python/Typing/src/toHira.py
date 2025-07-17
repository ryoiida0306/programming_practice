import MeCab


def hira_convert(text):
    tagger = MeCab.Tagger()
    hira = []
    split_text = tagger.parse(text).split("\n")
    for i in range(len(split_text)-2):
        arr = split_text[i].split("\t")
        iskanji = False
        for char in arr[0]:
            if char >= u'\u4e00' and char <= u'\u9faf':
                iskanji = True
                break
        if iskanji:
            if len(arr) > 2:
                hira.append(arr[2])
        else:
            hira.append(arr[0])
    hira_kana_text = " ".join(hira)
    hira_text = ""
    for i in range(len(hira_kana_text)):
        if hira_kana_text[i] == " " : continue
        if hira_kana_text[i] >= 'ァ' and hira_kana_text[i] <= 'ヶ':
            hira_text += chr(ord(hira_kana_text[i]) -96)
        elif hira_kana_text[i] >= 'ア' and hira_kana_text[i] <= 'ン':
            hira_text += chr(ord(hira_kana_text[i]) -96)
        else :
            hira_text += hira_kana_text[i]
    return hira_text



# tagger = MeCab.Tagger()

# text = "どんな言葉でもABCでも基本的には1行目には品詞が、2行目には原形が、9行目には品詞細分類が、10行目には活用形が、11行目には活用型が、12行目には原形が出力されます。"

# hira = []

# print(tagger.parse(text))

# split_text = tagger.parse(text).split("\n")

# for i in range(len(split_text)-2):
#     arr = split_text[i].split("\t")
#     iskanji = False
#     for char in arr[0]:
#         if char >= u'\u4e00' and char <= u'\u9faf':
#             iskanji = True
#             break
#     if iskanji:
#         if len(arr) > 2:
#             hira.append(arr[2])
#     else:
#         hira.append(arr[0])

# hira_kana_text = " ".join(hira)

# # print(hira)

# hira_text = ""

# for i in range(len(hira_kana_text)):
#     if hira_kana_text[i] == " " : continue
#     if hira_kana_text[i] >= 'ァ' and hira_kana_text[i] <= 'ヶ':
#         hira_text += chr(ord(hira_kana_text[i]) -96)
#     elif hira_kana_text[i] >= 'ア' and hira_kana_text[i] <= 'ン':
#         hira_text += chr(ord(hira_kana_text[i]) -96)
#     else :
#         hira_text += hira_kana_text[i]

# print(hira_text)



