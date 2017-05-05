#!/bin/sh

filepath=$1
compiled=${filepath%%.*}

# コンパイルと実行
javac -encoding UTF-8 ${filepath}
java ${compiled}

# コンパイルファイルの削除
rm -f ${compiled}.class
