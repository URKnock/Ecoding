import sys
from gensim import models

def main(arg):
	model = models.fasttext.load_facebook_model('cc.ko.1.bin')
	print(arg[1])
	print("%.10f" %(model.wv.similarity("환경", arg[1])))

if __name__ == "__main__":
	main(sys.argv)