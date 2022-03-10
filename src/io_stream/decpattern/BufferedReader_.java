package io_stream.decpattern;

/**
 * 处理流--可以实现文件和字符串的读取
 */
public class BufferedReader_ extends Reader_ {
    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    //扩展了FileReader_的功能，多次读取文件，本来只能读取一次
    public void readFiles() {
        for (int i = 0; i < 5; i++) {
            reader_.readFile();
        }
    }

    //扩展FileString_的功能，多去读取字符串
    public void readStrings(){
        for (int i = 0; i < 5; i++) {
            reader_.readString();
        }
    }


}
