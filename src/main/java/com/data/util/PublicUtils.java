package com.data.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: ps
 * @Description: 公共工具
 * @Date: Created in 2021/12/1 9:24
 */
@Slf4j
public class PublicUtils {

    /**
     * Description: Java8 Stream分割list集合
     *
     * @param list      集合数据
     * @param splitSize 几个分割一组
     * @return 集合分割后的集合
     */
    public static <T> List<List<T>> splitList(List<T> list, int splitSize) {
        //计算分割后的大小
        int maxSize = (list.size() + splitSize - 1) / splitSize;
        //开始分割
        return Stream.iterate(0, n -> n + 1)
                .limit(maxSize)
                .parallel()
                .map(a -> list.parallelStream().skip(a * splitSize).limit(splitSize).collect(Collectors.toList()))
                .filter(b -> !b.isEmpty())
                .collect(Collectors.toList());
    }

    /**
     * @Author: ps
     * @Description: 读取文件内容
     * @Date: Created in 2021/9/23 9:53
     * @params: [path]
     * @return: java.lang.String
     */
    public static String readFile(String path) {

        File file = new File(path);
        if(!file.exists()){
            return "false";
        }

        String str = null;
        try(FileInputStream fis = new FileInputStream(file);
            FileChannel fc = fis.getChannel();){

            ByteBuffer bb = ByteBuffer.allocate(new Long(file.length()).intValue());
            //fc向buffer中读入数据
            fc.read(bb);
            bb.flip();
            str = new String(bb.array(), "UTF-8");

        }catch (Exception e){
            e.printStackTrace();
            log.error("{}读取文件失败{}",path,e.getMessage());
        }
        /*FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(new Long(file.length()).intValue());
        //fc向buffer中读入数据
        fc.read(bb);
        bb.flip();
        String str = new String(bb.array(), "UTF-8");
        fc.close();
        fis.close();*/
        return str;
    }

    /**
     * @Author: ps
     * @Description: 复制文件
     * @Date: Created in 2021/9/23 14:13
     * @params: [oldFile, bakPath, flag]
     * @return: void
     */
    public static String moveFile(String filePath, String bakPath, String flag,String type) {
        File oldFile = new File(filePath);
        String newPath = bakPath + File.separator + flag + File.separator + type + File.separator + LocalDateTime.now().format(DateTimeFormatter
                .ofPattern("yyyyMMdd"));
        File directory = new File(newPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        try {
            File file = FileUtils.getFile(newPath + File.separator + oldFile.getName());
            if(file.exists()){
                file.delete();
            }
            FileUtils.copyFileToDirectory(oldFile,directory);
        } catch (Exception e) {
            log.error("复制文件失败：", oldFile.getName(), e);
            newPath = null;
        }
        return newPath;
    }

    public static void toFile(String filepath, String content) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
                new FileOutputStream(filepath))) {
            bufferedOutputStream.write(content.getBytes("UTF-8"));
        }
    }

    /**
     * @Author: ps
     * @Description: 文件复制
     * @Date: Created in 2021/12/28 17:16
     * @params: [s, t]
     * @return: void
     */
    public static void fileChannelCopy(File s, File t) {
        FileInputStream fi = null;
        FileOutputStream fo = null;
        FileChannel in = null;
        FileChannel out = null;
        try {
            fi = new FileInputStream(s);
            fo = new FileOutputStream(t);
            //得到对应的文件通道
            in = fi.getChannel();
            //得到对应的文件通道
            out = fo.getChannel();
            //连接两个通道，并且从in通道读取，然后写入out通道
            in.transferTo(0, in.size(), out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fi.close();
                in.close();
                fo.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static <T> T xml2JavaBean(String xml, Class<T> tClass, String charset) throws JAXBException, UnsupportedEncodingException {
        xml = xml.replaceAll("[\\x00-\\x08\\x0b-\\x0c\\x0e-\\x1f]", "");
        JAXBContext jaxbContext = JAXBContext.newInstance(tClass);
        Unmarshaller um = jaxbContext.createUnmarshaller();
        T t = (T) um.unmarshal(new ByteArrayInputStream(xml.getBytes(charset)));
        return t;
    }

    public static Map<String,Object> dxpMsg(String path){

        // 读取xml文件内容
        String xmlStr = readFile(path);
        if("false".equals(xmlStr)){
            return null;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("path",path);
        try{
            Document doc = DocumentHelper.parseText(xmlStr);
            Element element = doc.getRootElement();
            Iterator iter = element.elementIterator("TransInfo");
            while (iter.hasNext()) {
                Element recordEle = (Element) iter.next();
                String copMsgId = recordEle.elementTextTrim("CopMsgId");
                map.put("copMsgId",copMsgId);
                String senderId = recordEle.elementTextTrim("SenderId");
                map.put("senderId",senderId);
                String creatTime = recordEle.elementTextTrim("CreatTime");

                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                Date date= sd.parse(creatTime);
                map.put("xmlCreatTime",date);
                String msgType = recordEle.elementTextTrim("MsgType");
                map.put("msgType",msgType);
                Iterator iter1 = recordEle.elementIterator("ReceiverIds");
                String receiverIds = "";
                while (iter1.hasNext()) {
                    Element elm = (Element) iter1.next();
                    receiverIds = receiverIds + elm.elementTextTrim("ReceiverId") + ",";
                }
                map.put("receiverId",receiverIds.substring(0,receiverIds.length()-1));
            }

            Iterator iter3 = element.elementIterator("AddInfo");
            while (iter3.hasNext()) {
                Element recordEle = (Element) iter3.next();
                String fileName = recordEle.elementTextTrim("FileName");
                map.put("fileName",fileName);
                String icCard = recordEle.elementTextTrim("IcCard");
                map.put("icCard",icCard);
                Iterator iter4 = recordEle.elementIterator("BizKey");
                String Key = "";
                while (iter4.hasNext()) {
                    Element elm = (Element) iter4.next();
                    Key = Key + elm.elementTextTrim("Key") + ",";
                }
                map.put("bizKey",Key.substring(0,Key.length()-1));
            }

            //Base64 解密
            byte[] decoded = Base64.getDecoder().decode(element.elementTextTrim("Data"));
            String decodeStr = new String(decoded);
            map.put("data",decodeStr);
        }catch (Exception e){
            log.error("解析出错{}",e.getMessage());
            return null;
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        File oldFile = new File("F:\\client.keystore");
        File directory = new File("F:\\zbqLog");

        FileUtils.copyFileToDirectory(oldFile,directory);
    }
}
