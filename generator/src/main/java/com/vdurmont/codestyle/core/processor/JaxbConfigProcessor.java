package com.vdurmont.codestyle.core.processor;

import com.vdurmont.codestyle.core.exception.CodeStyleException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class JaxbConfigProcessor<T> implements ConfigProcessor<T> {
    private final Class<T> targetClass;
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final Map<String, Object> properties;

    public JaxbConfigProcessor(Class<T> targetClass) {
        this.properties = new HashMap<>();
        this.targetClass = targetClass;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(targetClass);
            this.marshaller = jaxbContext.createMarshaller();
            this.marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            this.unmarshaller = jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            throw new CodeStyleException("Unable to initialize the reader.", e);
        }
    }

    @Override
    public T readFromStream(InputStream stream) {
        try {
            return this.targetClass.cast(this.unmarshaller.unmarshal(stream));
        } catch (JAXBException e) {
            throw new CodeStyleException("An error occurred while reading stream.", e);
        }
    }

    @Override
    public void writeToStream(T input, OutputStream stream) {
        try {
            for (Map.Entry<String, Object> entry : this.properties.entrySet()) {
                this.marshaller.setProperty(entry.getKey(), entry.getValue());
            }
            this.marshaller.marshal(input, stream);
        } catch (JAXBException e) {
            throw new CodeStyleException("An error occurred while writing the object: " + input + " to the stream.", e);
        }
    }

    protected void addProperty(String key, Object value) {
        this.properties.put(key, value);
    }
}
