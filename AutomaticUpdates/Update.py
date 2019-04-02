import glob, os



def find_files_in_dir() :
    #os.chdir("/" + directory)
    for file in glob.glob("*.txt") :
        if "_MD" in file :
            pass