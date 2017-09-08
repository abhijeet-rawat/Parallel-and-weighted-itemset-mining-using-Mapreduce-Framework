#!/bin/bash
cd /usr/local/hadoop/bin
./hadoop fs -copyToLocal $1 $2
