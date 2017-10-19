#! /bin/bash

mkdir -p ~/.gpg/
openssl aes-256-cbc -K $encrypted_3e1475539c2f_key -iv $encrypted_3e1475539c2f_iv -in .travis/gpg/gpg.tar.enc -out ~/.gpg/gpg.tar -d
tar xvf ~/.gpg/gpg.tar -C ~/.gpg/
for i in priv pub; do
    cat ~/.gpg/travis.$i | gpg --dearmor > ~/.gpg/travis.$i.bin
done
