import sys
a = 0
for line in sys.stdin:
    a += 1
    if a % 1000000 == 0:
        print >> sys.stderr, str(a) + " of 200000000"
    user_id = line.split("\t")[0]
    tweet_id = line.split("\t")[1]
    score = line.split("\t")[2]
    timestring = line.split("\t")[3]
    tweet = line.split("\t")[4]
    l = user_id+":"+timestring + "\t" + tweet_id+":"+score+":"+tweet
    sys.stdout.write(l)
