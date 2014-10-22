# from gm_main import *
import os
import sys
def main():
  numfile = 24
  monthDict = {'Jan':'01', 'Feb':'02', 'Mar':'03', 'Apr':'04', 'May':'05', 'Jun':'06', 'Jul':'07', 'Aug':'08', 'Sep':'09', 'Oct':'10', 'Nov':'11', 'Dec':'12'}
  for i in range(numfile):
    if i < 10:
      filenamenum = "0000" + str(i)
    if i > 10:
      filenamenum = "000" + str(i)
    inputfile = open("part-"+filenamenum,'r')
    outputfile = open("out-part-"+filenamenum,'w')
    inputcontent = inputfile.read().splitlines()
    for line in inputcontent:
      if len(line.split('\t')) == 5:
        user_id = line.split('\t')[0]
        timestring = line.split('\t')[1]
        timestring = timestring
        month = monthDict[timestring[4:7]]
        timestring = timestring[26:30]+'-'+month+'-'+timestring[8:10]+'+'+timestring[11:19]
        tweet_id = line.split('\t')[2]
        sentiment = line.split('\t')[3]
        tweet = line.split('\t')[4]
        outputfile.write(user_id+':'+timestring+'\t'+tweet_id+'\t'+sentiment+'\t'+tweet+'\n')
main()
