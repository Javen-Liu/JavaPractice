package StringBuffer;

/**
 * @author 刘建雯
 */
public interface IStringBuffer {
    /**
     * @author [刘建雯]
     * @Description: [添加字符串]
     * @Param [str插入的字符串]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void append(String str);

    /**
     * @author [刘建雯]
     * @Description: [添加字符]
     * @Param [c是插入的字符]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void append(char c);

    /**
     * @author [刘建雯]
     * @Description: [添加字符数组]
     * @Param [chars是插入的字符数组]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void append(char[] chars);

    /**
     * @author [刘建雯]
     * @Description: [指定位置插入字符串]
     * @Param [pos是插入位置,str是插入的字符串]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void insert(int pos,String str) throws Exception;

    /**
     * @author [刘建雯]
     * @Description: [指定位置插入字符]
     * @Param [pos是插入位置,是插入的字符串]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void insert(int pos,char c) throws Exception;

    /**
     * @author [刘建雯]
     * @Description: [删除字符]
     * @Param [start代表删除开始的位置]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void delete(int start) throws Exception;

    /**
     * @author [刘建雯]
     * @Description: [删除固定长度的字符]
     * @Param [start与end代表开始与结束删除操作的位置]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void delete(int start,int end) throws Exception;

    /**
     * @author [刘建雯]
     * @Description: [将字符串全部反转]
     * @Param [void]
     * @Return [void]
     * @Date [2019/11/20 15:43]
     */
    public void reverse();

    /**
     * @author [刘建雯]
     * @Description: [添加字符获取长度]
     * @Param [void]
     * @Return [int]
     * @Date [2019/11/20 15:43]
     */
    public int length();

    /**
     * @author [刘建雯]
     * @Description: [获取目前MyStringBuffer的容量大小]
     * @Param [void]
     * @Return [int]
     * @Date [2019/11/20 15:43]
     */
    public int getCapacity();
}
