package com.webchat.webchat.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CallPojo {
    private String caller;
    private String listener;
    private String imageCaller;
    private String fullnameCaller;
    private String rooomId;
    private String status;

    @Override
    public String toString() {
        return "CallPojo{" +
                "caller='" + caller + '\'' +
                ", listener='" + listener + '\'' +
                ", ImageCaller='" + imageCaller + '\'' +
                ", fullnameCaller='" + fullnameCaller + '\'' +
                ", rooomId='" + rooomId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
