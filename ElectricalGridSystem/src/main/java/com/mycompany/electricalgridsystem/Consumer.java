package com.mycompany.electricalgridsystem;

public class Consumer {
               
    public float consumed;
    public String consumerName, typeOfConsumer, address;

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getTypeOfConsumer() {
        return typeOfConsumer;
    }

    public void setTypeOfConsumer(String typeOfConsumer) {
        this.typeOfConsumer = typeOfConsumer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Consumer(float consumed){
        this.consumed = consumed;
    }
    
}
