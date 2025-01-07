package co.com.literalura.service;

public interface IConvertData {
    <T> T getApiData(String json, Class<T> model);
}
