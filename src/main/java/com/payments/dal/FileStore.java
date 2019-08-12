package com.payments.dal;

import com.payments.domain.payment_way.Payment;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage data on File.
 */
@Service
public class FileStore implements DataAction<Payment> {
    private ObjectOutputStream objectOutputStream;
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private ObjectInputStream objectInputStream;

    private static final String nameFile = "payments.txt";

    public FileStore() {
        this.openToWriteOnFile(nameFile);
    }

    private void openToWriteOnFile(String nameFile) {
       try {
           fileOutputStream = new FileOutputStream(new File(nameFile));
           objectOutputStream = new ObjectOutputStream(fileOutputStream);
       } catch (Exception ex) {
            this.closeFile();
       }
    }

    private void openToReadOnFile(String nameFile) {
        try {
            fileInputStream = new FileInputStream(nameFile);
            objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (Exception ex) {
            this.closeFile();
        }
    }

    private void closeFile() {
        try {
            objectOutputStream.close();
        } catch (Exception ex) {

        }
    }

    @Override
    public boolean save(Payment data) {
        try {
            objectOutputStream.writeObject(data);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<Payment> findAll() {
        List<Payment> objects = new ArrayList<>();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nameFile));
            Object obj;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Payment) {
                    objects.add((Payment) obj);
                }
            }
            inputStream.close();
        }catch (Exception ex) {

        }
        return objects;
    }
}
