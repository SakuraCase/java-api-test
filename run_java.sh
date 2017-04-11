#!/bin/sh

# 簡易java実行環境

filepath=$1
compiled=${filepath%%.*}

# コンパイルと実行
docker run --rm -v "$PWD":/usr/src -w /usr/src openjdk:9 javac ${filepath}
docker run --rm -v "$PWD":/usr/src -w /usr/src openjdk:9 java ${compiled}

# コンパイルファイルの削除
rm -f ${compiled}.class

# 参考
# https://hub.docker.com/_/openjdk/
