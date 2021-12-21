import sys

def main(arg):
	count = {}
	word = ('.', ',', '!', '?', ':', '은', '는', '이', '가', '을', '를', '의', '에', '에게', '께서', '우리', '제', '내')
	filename = arg[1] + "/temp.txt"
	with open(filename, 'rt', encoding='cp949') as f:
		content = f.readlines()
		content = content[0]
		for w in word:
			content = content.replace(w, ' ')
		content = content.split(' ')
		for c in content:
			count[c] = count.get(c, 0) + 1
		del count['']
	count = sorted(count.items(), key=lambda x:x[1], reverse=True)
	print(count[0][0])

if __name__ == "__main__":
	main(sys.argv)
