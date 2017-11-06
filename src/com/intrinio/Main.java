package com.intrinio;

import com.intrinio.realtime.Quote;
import com.intrinio.realtime.QuoteHandler;
import com.intrinio.realtime.RealTimeClient;

public class Main {

    public static void main(String[] args) throws Exception {
        String username = "YOUR_INTRINIO_API_USERNAME";
        String password = "YOUR_INTRINIO_API_PASSWORD";

        try (RealTimeClient client = new RealTimeClient(username, password, RealTimeClient.Provider.QUODD)) {
            client.registerQuoteHandler(new QuoteHandler() {
                @Override
                public void onQuote(Quote quote) {
                    System.out.println(quote.toString());

                }
            });

            String[] channels = new String[]{"BAC.NB"};
            client.join(channels);
            client.connect();
        }
    }
}
