#!/usr/bin/python

import sys

magic = '&efas&'

for line in sys.stdin:
	line = line.replace('\n', '')
	key, value= line.split('\t')
	userid, date = key.split(magic)
	textid, score, text = value.split(magic)
	print '%s\t%s\t%s\t%s\t%s' % (userid, date, textid, score, text)