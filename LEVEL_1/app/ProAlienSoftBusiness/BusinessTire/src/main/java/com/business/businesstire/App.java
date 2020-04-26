package com.business.businesstire;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class App implements BusinessTire.BTCallbacks {
    BusinessTire businessTire;
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        App app = new App();
        app.initUI();
    }

    public void initUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        businessTire = new BusinessTire();
        businessTire.setBtCallbacks(this);
        businessTire.setupButtons();
        businessTire.setVisible(true);
        businessTire.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                try {
                    LoadMetadata();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public void LoadMetadata() throws Exception {
        sendGet();
    }

    private void sendGet() throws Exception {
        HttpGet request = new HttpGet("http://localhost:8081/LoadXmlCache");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println(response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                JSONArray jsonArray = new JSONArray(result);
                String[][] data = new String[jsonArray.length()][2];
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    data[i][0] = object.getString("data1");
                    data[i][1] = object.getString("data2");
                }
                businessTire.AddMetaDataToTable(data);
            }

        }
        businessTire.StartBT();

    }

    @Override
    public void RefreshMetadata() throws Exception {
        sendGet();
    }
}
