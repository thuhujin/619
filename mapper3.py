#!/usr/bin/python

import sys
import string
import json

magic = '&efas&'
newline = '&nnorge&'

for line in sys.stdin:
	try:
		if line == '\n':
			continue
		content = json.loads('['+line+']')[0]
		key = content['user']['id_str']+magic+content['created_at']
		text = content['text']
		text = text.replace('\n', newline).encode('utf-8')
		keyv = (key+'\t'+content['id_str']+magic).encode('utf-8')+text

		if keyv is '\t':
			continue
		print keyv
	except:
		continue