package leecode.easy.rand;

import java.util.ArrayList;
import java.util.List;

public class FriendCircles {
    public int findCircleNum(int[][] M) {
        GroupStruct groupStruct = new GroupStruct();
        for (int i = 0; i < M.length; i++) {
            int[] ints = M[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt == 1) {
                    int jF = groupStruct.find(j);
                    int iF = groupStruct.find(i);
                    if (jF == -1 && iF == -1) {
                        int groupI = groupStruct.addNew(j);
                        groupStruct.add(groupI, j);
                    } else if (jF == -1 && iF != -1) {
                        groupStruct.add(iF, j);
                        System.out.println(111);
                    } else if (jF != -1 && iF == -1) {
                        groupStruct.add(jF, i);
                        System.out.println(222);
                    } else if(jF!=iF){
                        groupStruct.marge(jF,iF);
                    }
                }
            }

        }
        return groupStruct.size();
    }

    class GroupStruct {
        List<List<Integer>> groupList = new ArrayList<>();

        public void add(int group, int people) {
            groupList.get(group).add(people);
        }

        public int addNew(int people) {
            ArrayList<Integer> objects = new ArrayList<>();
            objects.add(people);
            groupList.add(objects);
            return groupList.indexOf(objects);
        }

        public int find(int people) {
            int i =0;
            for (; i < groupList.size(); i++) {
               if(groupList.get(i).contains(people)){
                   return i;
               };
            }
            return -1;
        }

        public int size() {
            return groupList.size();
        }

        public void marge(int i, int j) {
            groupList.get(i).addAll(groupList.get(j));
            groupList.remove(j);
        }
    }

}
