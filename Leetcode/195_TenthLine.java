# Read from the file file.txt and output the tenth line to stdout.
awk 'NR==10' file.txt
# awk is the build in function which is used to manipulate files, to extract data from files, NR is used for No. of Records which are usually no. of lines in the file