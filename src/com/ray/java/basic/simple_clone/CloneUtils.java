package com.ray.java.basic.simple_clone;

import java.io.*;

/**
 * Created by dangdang on 6/22/16.
 */
public class CloneUtils {

    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;

        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            cloneObj = (T) ois.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cloneObj;
    }
}
