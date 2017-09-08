#!/bin/sh
cd /usr/local/hadoop/bin
./hadoop fs -put $1 $2
