import random

class Example:
    hierarchy = {'feature': ['transport feature', 'building'],
                 'transport feature': ['road', 'railway', 'toll house', 'station'],
                 'building': ['station', 'church', 'house'],
                 'road': ['toll road', 'minor road', 'major road'],
                 'toll road': ['minor toll-road'],
                 'minor road': ['minor toll-road'],
                 'house': ['toll house']
                 }

    # dynamic set
    def dynamicset(self):
        set = {'t1': (('toll house', 1), ('minor toll-road', 2), ('railway', 3)),
               't2': (('house', 4), ('house', 5), ('minor road', 6)),
               't3': (('church', 7), ('railway', 8))
               }
        return set

    # support relation between entities
    def relation(self):
        rel = [{'o': 1, 't': 4}, {'o': 1, 't': 5},
               {'o': 3, 't': 6}, {'o': 2, 't': 6},
               {'o': 4, 't': 7}, {'o': 5, 't': 0}, {'o': 6, 't': 8},
               {'o': 7, 't': 'N'}, {'o': 8, 't': 'N'}]
        return rel

    # Find all paths from a FEATURE to a point
    def find_path(self, start, end, path=[]):
        path = path + [start]
        if start == end:
            return [path]
        if start not in self.hierarchy.keys():
            return []
        if end == '':
            return ['']
        paths = []
        for node in self.hierarchy[start]:
            if node not in path:
                newpaths = self.find_path(node, end, path)
                for newpath in newpaths:
                    paths.append(newpath)
        return paths

    # Returns a list of entities that can be merged
    def support(self,cset,rel,stime,etime):
        sdset = cset
        rela = rel
        dui = {}
        for i in sdset[stime]:
            v = []
            for j in sdset[etime]:
                for r in rela:
                    if i[1] == r['o'] and j[1] == r['t']:
                        v.append(j)
                        dui[i] = v
        pre = []
        for key, value in dui.items():
            eg = []
            eg.append(key)
            for i in value:
                eg.append(i)
            pre.append(eg)
        for i in pre:
            for j in pre[pre.index(i) + 1:]:
                for k in i:
                    for z in j:
                        if k == z:
                            newlist = list(set(i + j))
                            pre.remove(i)
                            pre.remove(j)
                            pre.append(newlist)
        return pre

    # Find the path to each instance
    def compath(self, d):
        ppath = {}
        for s in d:
            j = 0
            thingpaths = Example.find_path(self, 'feature', s[0], path=[])
            for thingpath in thingpaths:
                ppath[s[0] + str(j)] = thingpath
                j = j + 1
        return ppath

    # Find common points in paths
    def samepath(self,cset,rel,stime,etime):
        dset = Example.support(self,cset,rel,stime,etime)
        savepoint = []
        for d in dset:
            zsbl = []
            samepoint = []
            k = []
            new = []
            p = self.compath(d)
            for o in p.keys():
                k.append(o)
            for i in k:
                temvar = []
                for j in k[k.index(i) + 1:]:
                    if i[:-1] == j[:-1]:
                        k.remove(j)
                        temvar.append(j)
                if temvar:
                    k.remove(i)
                    temvar.append(i)
                    new = temvar
            if not new:
                for w in k:
                    for e in k[k.index(w) + 1:]:
                        list1 = p[w]
                        list2 = p[e]
                        a = [x for x in list1 if x in list2]
                        samepoint.append(a)
                if len(samepoint) > 1:
                    for l in samepoint:
                        for g in zsbl[samepoint.index(l) + 1:]:
                            if len(l) > len(g):
                                longest = g
                            else:
                                longest = l
                else:
                    longest = samepoint[0]
                savepoint.append(longest[-1])
            elif new:
                for n in k:
                    for m in new:
                        list1 = p[n]
                        list2 = p[m]
                        a = [x for x in list1 if x in list2]
                        samepoint.append(a)
                    if samepoint == []:
                        continue
                    else:
                        for l in samepoint:
                            for g in samepoint[samepoint.index(l) + 1:]:
                                if len(l) < len(g):
                                    longest = g
                                else:
                                    longest = l
                    zsbl.append(longest)
                if len(zsbl) > 1:
                    for l in zsbl:
                        for g in zsbl[zsbl.index(l) + 1:]:
                            if len(l) > len(g):
                                longest = g
                            else:
                                longest = l
                savepoint.append(longest[-1])
        return savepoint

    # Output dynamic set
    def dataout(self, time):
        data = self.dynamicset()
        infoo = []
        info = data.get(time)
        for i in info:
            j = list(i)
            infoo.append(j[0])
        timedata = {time: infoo}
        return timedata

    #Finding supportive relationships
    def findrel(self,cset,rel,stime,etime):
        mergelist = Example.samepath(self,cset,rel,stime,etime)
        rnum = []
        count = random.randint(9,100)
        dset = Example.support(self,cset,rel,stime, etime)
        for rc in rel:
            rnum.append(rc['o'])
            rnum.append(rc['t'])
        rnum = set(rnum)
        if count not in rnum:
            temlist = []
            for i in dset:
                rellist = []
                name = []
                for j in i:
                    for r in rel:
                        if j[1] == r['o']:
                            if r['t'] != 0:
                                rellist.append(r['t'])
                    name.append(j[1])
                for l in rellist:
                    for m in mergelist:
                        if l not in name:
                            rel.append({'o': count, 't': l})
                            mergelist.remove(m)
                            newentity = (m,count)
                            temlist.append(newentity)
                            count = random.randint(9, 100)
                            break
            finentity = tuple(temlist)
        return rel,finentity

    #merging
    def run(self,newtime,newrel,newset):
        p = {}
        newdict = []
        i = newtime[0]
        if len(newtime) > 1:
            j = newtime[newtime.index(i) + 1]
            newrel, p[i+','+j] = Example.findrel(self,newset,newrel,i,j)
            del newset[i]
            del newset[j]
            newset.update(p)
            newtime.remove(i)
            newtime.remove(j)
            newtime.append(str(i) + ',' + str(j))
            if len(newtime)>1:
                newdict.append(newtime[-1])
                newdict[1:] = newtime[:-1]
                newtime = newdict
                p = self.run(newtime,newrel,newset)
            else:
                return p
        return p

e = Example()
p = {}
outdata = {}
value = []
newset = e.dynamicset()
newrel = e.relation()
time = input('Input the time and separated as space:')
newtime = time.split(' ')
set = e.run(newtime,newrel,newset)
for k,v in set.items():
    for vi in v:
        value.append(vi[0])
    set[k]=value
print('The result of the merging is:')
print(set)
