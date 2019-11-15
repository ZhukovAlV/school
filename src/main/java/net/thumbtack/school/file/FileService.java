package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;
import net.thumbtack.school.windows.v4.Point;
import net.thumbtack.school.windows.v4.RectButton;
import net.thumbtack.school.windows.v4.base.WindowException;
import net.thumbtack.school.windows.v4.base.WindowState;

import java.io.*;
import java.util.ArrayList;


public class FileService {

    public static void  writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)){
            fileOutputStream.write(array);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void  writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile (new File(fileName), array);
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        byte[] result = null;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            result = new byte[fileInputStream.available()];
            fileInputStream.read(result);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile (new File(fileName));
    }

    public static byte[]  writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte [] result = new byte [(array.length % 2 == 0) ? array.length/2 : array.length/2 + 1];
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byteArrayOutputStream.write(array);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream (byteArrayOutputStream.toByteArray());
            for (int i = 0; i < result.length; i++) {
                result [i] = (byte) byteArrayInputStream.read();
                byteArrayInputStream.skip(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public static void  writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFileBuffered (new File(fileName), array);
    }

    public static void  writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file))){
            bufferedOutputStream.write(array);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        byte[] result = null;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file))) {
            result = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(result);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFileBuffered (new File (fileName));
    }

    public static void  writeRectButtonToBinaryFile(File file, RectButton rectButton) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeInt(rectButton.getTopLeft().getX());
            dataOutputStream.writeInt(rectButton.getTopLeft().getY());
            dataOutputStream.writeInt(rectButton.getBottomRight().getX());
            dataOutputStream.writeInt(rectButton.getBottomRight().getY());
            dataOutputStream.writeUTF(rectButton.getState().toString());
            dataOutputStream.writeUTF(rectButton.getText());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static RectButton readRectButtonFromBinaryFile(File file) throws IOException, WindowException {
        RectButton rectButton = null;
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            int xTopLeft = dataInputStream.readInt();
            int yTopLeft = dataInputStream.readInt();
            int xBottomRight = dataInputStream.readInt();
            int yBottomRight = dataInputStream.readInt();
            String state = dataInputStream.readUTF();
            String text = dataInputStream.readUTF();
            rectButton = new RectButton(new Point(xTopLeft, yTopLeft), new Point(xBottomRight, yBottomRight), state, text);
        } catch (IOException | WindowException e) {
            e.printStackTrace();
            throw e;
        }
        return rectButton;
    }

    public static void  writeRectButtonArrayToBinaryFile(File file, RectButton[] rects) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            for (RectButton element : rects) {
                dataOutputStream.writeInt(element.getTopLeft().getX());
                dataOutputStream.writeInt(element.getTopLeft().getY());
                dataOutputStream.writeInt(element.getBottomRight().getX());
                dataOutputStream.writeInt(element.getBottomRight().getY());
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void  modifyRectButtonArrayInBinaryFile(File file) throws IOException, WindowException {
        RectButton[] buttons = readRectButtonArrayFromBinaryFile(file);
        for (RectButton button : buttons) {
            button.moveRel(1, 0);
        }
        writeRectButtonArrayToBinaryFile(file, buttons);
    }

    public static RectButton[] readRectButtonArrayFromBinaryFile(File file) throws IOException, WindowException {
        ArrayList<RectButton> rectButtonArrayList = new ArrayList<>();
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            while (dataInputStream.available() > 0) {
                int xTopLeft = dataInputStream.readInt();
                int yTopLeft = dataInputStream.readInt();
                int xBottomRight = dataInputStream.readInt();
                int yBottomRight = dataInputStream.readInt();
                rectButtonArrayList.add(new RectButton(new Point(xTopLeft, yTopLeft),new Point(xBottomRight, yBottomRight), WindowState.ACTIVE, "OK"));
            }
            return rectButtonArrayList.toArray(new RectButton[rectButtonArrayList.size()]);
        } catch (IOException | WindowException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void writeRectButtonToTextFileOneLine(File file, RectButton rectButton) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF(rectButton.getTopLeft().getX() + " " + rectButton.getTopLeft().getY() + " "
                    + rectButton.getBottomRight().getX() + " " + rectButton.getBottomRight().getY() + " "
                    + rectButton.getState() + " " + rectButton.getText());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static RectButton readRectButtonFromTextFileOneLine(File file) throws IOException, WindowException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            String[] arr = dataInputStream.readUTF().split(" ");
            int xTopLeft = Integer.parseInt(arr[0]);
            int yTopLeft = Integer.parseInt(arr[1]);
            int xBottomRight = Integer.parseInt(arr[2]);
            int yBottomRight = Integer.parseInt(arr[3]);
            return new RectButton(new Point(xTopLeft, yTopLeft), new Point(xBottomRight, yBottomRight), arr[4], arr[5]);
        } catch (IOException | WindowException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void writeRectButtonToTextFileSixLines(File file, RectButton rectButton) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF(rectButton.getTopLeft().getX() + "\n"
                    + rectButton.getTopLeft().getY() + "\n" + rectButton.getBottomRight().getX()
                    + "\n" + rectButton.getBottomRight().getY() + "\n"
                    + rectButton.getState() + "\n" + rectButton.getText());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static RectButton readRectButtonFromTextFileSixLines(File file) throws IOException, WindowException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            String[] arr = dataInputStream.readUTF().split("\n");
            int xTopLeft = Integer.parseInt(arr[0]);
            int yTopLeft = Integer.parseInt(arr[1]);
            int xBottomRight = Integer.parseInt(arr[2]);
            int yBottomRight = Integer.parseInt(arr[3]);
            return new RectButton(new Point(xTopLeft, yTopLeft), new Point(xBottomRight, yBottomRight), arr[4], arr[5]);
        } catch (IOException | WindowException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF(trainee.getFirstName() + " " + trainee.getLastName() + " " + trainee.getRating());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }


    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            String[] traineeArr = dataInputStream.readUTF().split(" ");
            return new Trainee(traineeArr[0], traineeArr[1], Integer.parseInt(traineeArr[2]));
        } catch (IOException | TrainingException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file))) {
            dataOutputStream.writeUTF(trainee.getFirstName() + "\n" + trainee.getLastName() + "\n" + trainee.getRating());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            String[] traineeArr = dataInputStream.readUTF().split("\n");
            return new Trainee(traineeArr[0], traineeArr[1], Integer.parseInt(traineeArr[2]));
        } catch (IOException | TrainingException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            objectOutputStream.writeObject(trainee);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            return (Trainee)objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static String serializeTraineeToJsonString(Trainee trainee) {
        return new Gson().toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json) {
        return new Gson().fromJson(json,Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            gson.toJson(trainee, bw);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException {
        Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            return gson.fromJson(br,Trainee.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
