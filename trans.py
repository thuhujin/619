import string
rot13 = string.maketrans( 
    "ABCDEFGHIJKLMabcdefghijklmNOPQRSTUVWXYZnopqrstuvwxyz", 
    "NOPQRSTUVWXYZnopqrstuvwxyzABCDEFGHIJKLMabcdefghijklm")

f = open('banned', 'r')
banlist = list()
for word in f.readlines():
	word = word.replace('\n', '')
	banlist.append(string.translate(word, rot13))
print banlist

f2 = open('AFF', 'r')
scoretable = dict()
for line in f2.readlines():
	line = line.replace('\n', '')
	key, value = line.split('\t')
	scoretable[key] = int(value)
print scoretable