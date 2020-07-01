package sort;

/**
 * DataStructure
 * 排序算法
 *
 * @author : stc
 * @date : 2020-06-26 17:35
 **/
public class Sort {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,0,-1,-2,-3};
        heapSort(arr);
        print(arr);
    }
    public static void print(int[] arr){
        for (int i :arr){
            System.out.print(i+" ");
        }
    }
    /*
    冒泡排序
    最好情况On(已有序)
    最坏情况On^2逆序
    平均情况On^2
    空间复杂度O1
    稳定
    解释：从第一个元素开始，和右边的比大小，把大的换到右边去，直到遍历完数组，这样就能确定一个最大的数在最后，然后再从第二个元素开始做同样的事，确定了倒数第二大的数，
          每一外层循环确定一个数的位置
     */
    public static int[] bubbleSort(int[] arr){
        for (int i =0;i<arr.length;i++){
            for (int j =i+1;j<arr.length;j++){
                if (arr[j]<arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;

                }
            }
        }
        return arr;
    }

    /*
    插入排序
    最好情况On(已有序)
    最坏情况On^2逆序
    平均情况On^2
    空间复杂度O1
    稳定
    解释：将数组分为俩个部分，前面为有序，后面为无序（默认一开始第一个数就在有序部分中，因为一个数自然有序），然后每一轮循环从无序部分中找一个数，与有序部分的每一个作比较，
          将其放到合适的位置，这里每一次记录了一下这个无序部分被选出来的数，这样前半部分在做插入的时候就可以向后移动给这个数腾出空间（数组插入需要做位移）
     */
    public static int[] straightInsertionSort(int[] arr){
        for (int i =1;i<arr.length;i++){
            int key = arr[i];
            int j ;
            for (j = i-1;j>=0;j--){
                if (arr[j]>key){
                    arr[j+1] = arr[j];
                    arr[j] = key;
                }
            }
        }
        return arr;
    }

    /*
    选择排序
    最好情况On^2
    最坏情况On^2
    平均情况On^2
    空间复杂度O1
    不稳定
    解释：每一轮选择一个数，默认其为最小并记录它的下标，然后和后面的所有数比大小，如果有更小的就把下标换成这个数，最后再做一个比较，如果下标还是一开始选的那个数，就说明
          一开始默认选择的真的就是最小的，那就进行下一轮循环就好，如果下标变了，那就说明有一个更小的（其实也就是当前最小的），那就把这个数和一开始选择的数交换，这样每一轮
          就确定了一个数的位置(从小到大)
     */
    public static int[] selectSort(int[] arr){
        for (int i =0;i<arr.length;i++){
            int min_index = i;
            for (int j =i+1;j<arr.length;j++){
                if (arr[j]<arr[min_index]){
                    min_index = j;
                }
            }
            if (min_index!=i){
                int temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    /*
    快速排序
    最好情况Onlgn
    最坏情况On^2
    平均情况Onlgn
    空间复杂度O1gn(递归栈)
    不稳定
    解释：因为效率较高所以广泛使用，但在数据集比较小的时候快排没有一些简单算法快，快排主要分为两个部分，排序，递归
          首先选一个基准数（任意皆可，索性选第一个），从初始数组的左右开始向中间出发，先走右边，找到一个比基准数小的，那么把这个数放到基准数的位置，再走左边，找到一个比
          基准数大的，放到刚才拿出数的那个位置（也就是一开始把基准数取出后，数组中就会出现一个空缺，这样就不怕某一个数字丢失了），以此类推，当左右下标相遇时循环结束。此时
          的效果是一开始的基准数的左边都是比其小的，右边都是比其大的，这样一趟排序就完成了。
          之后进行递归，此时，对基准数左右两边的两个子数组进行上面的排序，分治之，当数组中只剩下一个数字时排序结束（因为左右下标相遇了），此时数组就有序了。
     */
    public static void quickSort(int[] arr,int lindex,int rindex){
        int pos = 0 ;  //声明一个pos下标，用来在递归时传入参数
        if(lindex<rindex){  //左右下标的判断 是递归出口
            int key = arr[lindex]; //用来存放基准数
            int l = lindex;
            int r = rindex;
            while (l<r){
                while (arr[r]>key){  //右下标对应的数字如果小于基准数，那右下标就一直向左走
                    if (r>lindex) {  //加上这个判断防止下标越界了
                        r--;
                    }else break;
                }
                if (l<r){                     // 当上面的这个循环结束，并且左右下标没有相遇时，说明找到了这个比基准数小的数，放在起初基准数的位置上，
                    arr[l] = arr[r];          // 此时左下标要右移，可以在左下标移动的时候少一次判断（因为已知比基准数小了）
                    l++;
                }
                while (arr[l]<key){          //左下标的循环是反向操作
                    if (l<rindex) { //加上这个判断防止下标越界了，如果没有这个判断，在左下标右移过程中，如果没找到比基准数更大的，那他就会一直右移，最后就会报越界异常
                        l++;
                    }else break;
                }
                if (l<r){
                    arr[r] = arr[l];
                    r--;
                }
                arr[l] = key;           //此时左右下标相遇了，而且相遇的这个坐标的数字肯定是上面遍历时最后一个移动出去的（可以试一试），所以此时把基准数放在这里
                pos= l;                  //左边都是比基准数小的右边都是大的，然后将左右下标相遇的位置赋值给pos
            }
            quickSort(arr,lindex,pos-1);  //递归调用 给左右子数组排序，左范围是（最左----基准数-1）  右范围是（基准数+1----最右）
            quickSort(arr,pos+1,rindex);
        }
    }

    /*
    希尔排序
    时间复杂度：On - On^2
    不稳定
    解释：先对整个数组进行分组，分组的跨度称为增量，一般增量选择为arr.length/2向下取整，比如说增量是3，那么下标为0,3,6…的元素为一组，然后进行组内的简单插入排序，然后将增量再次/2向下取整，
          这样循环下去，直到增量为1（每个组内只有一个元素），也就是最后一步对整个数组进行插入排序，但此时数组已经基本有序，所以效率要比直接进行插入排序好得多。
     */
    public static int[] shellSort(int[] arr){
        int incr = arr.length/2;  //初始化增量
        while (incr>=1) {   //推出循环条件，最后一次对全数组的插入排序结束
            for (int i=incr;i<arr.length;i+=incr){
                int key = arr[i];
                for (int j=i-incr;j>=0;j-=incr){
                    if (arr[j]>key){
                        arr[j+incr] = arr[j];
                        arr[j] = key;
                    }
                }

            }
            incr /= 2;

        }
        return arr;
    }

    /*
    折半插入排序
    时间复杂度：On^2（虽然和直接插入来比，比较次数减少了（指数级减少），但移动次数没变）
    稳定
    解释：还是插入排序的想法，但是对有序部分的操作不同，用一个low指针指向最小，high指向最大，mid指向(mid+high)/2，然后用当前插入元素和mid比较，如果mid大就把low+1，如果当前插入元素大就把high-1，
          循环再次求新的mid，这样循环下去，最后high会>low，此时找到了插入位置，high+1（也就是low），然后像插入排序一样，将前面的元素向后移，然后用待插元素插到空出来的high+1。
     */
    public static int[] binaryInsertSort(int[] arr){

        for (int i = 1;i<arr.length;i++){
            int low = 0;
            int high = i-1;
            while (low<=high){
                int mid = (low+high)/2 ;
                if (arr[mid]>arr[i]){
                    high = mid-1;
                }else {
                    low = mid+1;
                }
            }
            int key = arr[i];
            for (int j = i;j>high+1;j--){
                arr[j] = arr[j-1];
            }
            arr[high+1] = key;

        }
        return arr;
    }

    /*
    堆排序
    时间复杂度：Onlgn
    不稳定
    解释：一开始建初堆，然后在初堆的基础上每次循环将根节点和最后一个叶子结点交换，然后重建堆
    建初堆：将序列写成一个完全二叉树（数组天然形成），然后从最后一个非叶子结点开始，如果该节点的两个孩子中（或者一个）大于该节点，那么就把该节点和这个孩子节点交换（如果两个孩子都大，就交换大的那个孩子），
            然后循环进行直到根节点
    重建堆：根节点和最后一个叶子节点交换后，该树不再满足大根堆（或小根吨堆），那就按照建初堆的流程再对树进行处理（忽略刚刚交换到叶子结点的那个原根节点）

     */

    public static int[] heapSort(int[] arr){
        if (arr != null && arr.length>1){
            int pos = (arr.length -2) /2;  //最后一个非叶子结点
            while (pos>=0){  //循环一直进行到根节点
                rebuildHeap(arr,pos,arr.length-1);
                pos--;  // 从最后一个非叶子结点向根节点执行
            }
            for (int i = arr.length-1;i>0;i--){  //堆排序
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;  //根节点和最后一个叶子节点交换
                rebuildHeap(arr,0,i-1);//重建堆（end参数为i-1就是因为要排除刚刚换过来的那个结点）
            }
            return arr;
        }
        return arr;
    }

    private static void rebuildHeap(int[] arr , int pos , int end){  //重建堆（建初堆也是这样）
        int i = pos;
        int childPointer = 2*pos+1;  //最后一个非叶子节点的左孩子位置
        int key = arr[pos];  //暂存当前要重建的这个子树的父节点值，所以现在pos的位置可以占用不怕值丢失了
        while (childPointer<=end){  //用该结点还有没有子节点判断是不是向下建大根堆已经完成了
            if (childPointer < end && arr[childPointer+1] > arr[childPointer] ){  // 如果左孩子下标<end 也就是说明还有右孩子,并且右孩子大于左孩子的话，这个指针就指向右孩子
                childPointer++;  //指针指向右孩子
            }
            if (arr[childPointer]<=key){  //如果这个大的孩子已经小于父结点了，那就说明这个子树已经是个大根堆了，那么直接退出循环即可
                break;
            }else {
                arr[i] = arr[childPointer];  //如果这个大的孩子大于父结点，那么就把这个孩子放到pos位置
                i = childPointer;           //i指向孩子，向下迭代
                childPointer = 2*i+1;  // 孩子结点指向改编过的i的孩子
            }
        }
        arr[i] = key;  //最后不管重建过程有没有移动过，如果没有这句就没有效果，如果移动过，那么此时i指的是刚刚移动上去的孩子的那个位置，也就是说孩子现在在父节点上了，那么这句就是把父节点移动到孩子的位置
    }


}

