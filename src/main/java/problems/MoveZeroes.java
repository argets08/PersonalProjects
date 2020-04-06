package problems;

class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 0 1 0 3 12
        int zCount = 0;
        int k = 0;
        int t = 0;
        int numLen = nums.length;

//         int[] newNum = new int[numLen];
//         for (int i =0; i< numLen ; i++){
//             if(nums[i] != 0){
//                 newNum[t] = nums[i];
//                 t++;
//             }
//         }
//          for (int i = 0; i< numLen ; i++){
//                 nums[i] = newNum[i];
//             }
//         }

        for (int i = 0; i< nums.length; i++){
            if (nums[i] != 0){
                nums[t] = nums[i];
                t++;
                // if(i != nums.length-1)
                // nums[i] = nums[i+1];
            } else if (nums[i] == 0) {
                zCount ++;
                // t = i;
            }
            else{
                nums[k] = nums[i];
                k = i;
                System.out.println(k);
                // System.out.println(nums[k]);
            }
        }

        for (int j = 0; j < zCount ; j++){
            nums[numLen-j-1] = 0;
        }

    }
}
