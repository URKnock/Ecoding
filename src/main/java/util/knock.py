import sys
import random
# from gensim import models

def main(arg):
	# model = models.fasttext.load_facebook_model('cc.ko.1.bin')
	# print(arg[1])
	# print("%.9f" %(model.wv.similarity("환경", arg[1])))
	
	score = random.random()
	print("%.9f" %score)

if __name__ == "__main__":
	main(sys.argv)