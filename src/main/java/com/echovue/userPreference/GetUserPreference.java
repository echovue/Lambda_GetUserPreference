package com.echovue.userPreference;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.echovue.userPreference.model.PreferenceStatus;
import com.echovue.userPreference.model.UserPreference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetUserPreference implements RequestStreamHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handleRequest(final InputStream inputStream, final OutputStream outputStream,
                              final Context context) throws IOException {
        LambdaLogger logger = context.getLogger();
        logger.log("Loading Java Lambda handler of ProxyWithStream");

        UserPreference preference = new UserPreference("123ABC", "Home Page", "Google.com", PreferenceStatus.TEST);

        OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
        writer.write(mapper.writeValueAsString(preference));
        writer.close();
    }
}


