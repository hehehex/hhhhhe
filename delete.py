import random
import pandas as pd
import numpy as np

class Example:
    hierarchy = {'feature': ['transport feature', 'building'],
                 'transport feature': ['road', 'railway', 'toll house', 'station'],
                 'building': ['station', 'church', 'house'],
                 'road': ['toll road', 'minor road', 'major road'],
                 'toll road': ['minor toll-road'],
                 'minor road': ['minor toll-road'],
                 'house': ['toll house']
                 }

    # 动态集
    def dynamicset(self):
        set = {'t1': (('toll house', 1), ('minor toll-road', 2), ('railway', 3)),
               't2': (('house', 4), ('house', 5), ('minor road', 6)),
               't3': (('church', 7), ('railway', 8))
               }
        return set

    # 动态集实体之间的关系
    def relation(self):
        rel = [{'o': 1, 't': 4}, {'o': 1, 't': 5},
               {'o': 3, 't': 6}, {'o': 2, 't': 6},
               {'o': 4, 't': 7}, {'o': 5, 't': 0}, {'o': 6, 't': 8},
               {'o': 7, 't': 'N'}, {'o': 8, 't': 'N'}]
        return rel

    def findrel(self,set,time,rel):
        temrel = []
        delrel = []
        if time in set.keys():
            for i in set[time]:
                v, k = [], []
                for r in rel:
                    if r['o'] == i[1]:
                        v.append(r['t'])
                        delrel.append(r)
                    if r['t'] == i[1]:
                        k.append(r['o'])
                        delrel.append(r)
                for dr in delrel:
                    if dr in rel:
                        rel.remove(dr)
                for j in k:
                    for z in v:
                        dic = {}
                        dic['o']=j
                        dic['t']=z
                        temrel.append(dic)
            finrel = rel+temrel
            return finrel

e = Example()
set = e.dynamicset()
relation = e.relation()
time = input('Input time you want to move out:')
newtime = time.split(' ')
for t in newtime:
    rel = e.findrel(set,t,relation)
    del set[t]
print('Dynamic set after delete '+str(time)+':')
print(set)
print('Support relationship after delete '+str(time)+':')
print(rel)