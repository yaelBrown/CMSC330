from Parser import evaluate as p 
from tabulate import tabulate
from binarytree import tree, Node
from pyparsing import *

def readFile(): 
  f = open("sample-data.txt", "r")
  out = []

  print("\n")
  print("Project2: Reading Contents of File\n")

  for l in f: 
    out.append(l)
    print(f"\t{l}")
  
  print("\n")

  return out

def parser(dataList): 
  print("Project2: Evaluating each line")

  print("Project2: Generating table\n")
  table = []
  table.append(["Expression", "Result"])

  for l in dataList: 
    table.append([l, int(p(l))])

  print(tabulate(table, headers="firstrow"))
  print("\nProject2: Creating Binary Trees\n")

  def rearrange(tks):
    T=tks[0]
    T[0],T[1] = T[1],T[0]
    return tks

  expr = Forward()
  arithOp = Word( "+-*/", max=1 )
  terminal = ( Word(alphas, alphanums)
           | Word(nums)
           | Suppress("(") + expr + Suppress(")") )
  expr << Group(terminal + arithOp + terminal).setParseAction(rearrange)
  
  for l in dataList:
    pTree = expr.parseString(l)
    print(pTree)
    # bTree = generateBtree(pTree)
    # print(f"\n {bTree.properties}\n")


# def generateBtree(singleTree):
#   a = singleTree

#   root = gbtHelper(a[0][0])
#   root.left = gbtHelper(a[0][1])
#   root.right = gbtHelper(a[0][2])

#   return root

# def gbtHelper(v):
#   out = None

#   if type(v) == str:
#     out = Node(v)
#   elif type(v) == list:
#     if type(v[0]) == list:
#       gbtHelper(v[0])
#     out = Node(v[0])
#     out.left = Node(v[1])
#     out.right = Node(v[2])

#   return out

def run():
  parser(readFile())
  print("\n")

if __name__ == "__main__":
  run()


