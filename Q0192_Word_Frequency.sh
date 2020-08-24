cat words.txt | xargs printf "%s\n" | sort | uniq -c | sort -nr | awk '{print $2,$1}'
