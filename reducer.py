#!/usr/bin/python

import sys

magic = '&efas&'
old_id = None

for line in sys.stdin:
	line = line.replace('\n', '')
	key, value= line.split('\t')
	userid, date = key.split(magic)
	textid, score, text = value.split(magic)
	if textid == old_id:
		continue
	print '%s\t%s\t%s\t%s\t%s' % (userid, date, textid, score, text)
	old_id = textid