package kz.bitlab.techorda2025.thirdProject.interfaces.impls;

import kz.bitlab.techorda2025.thirdProject.interfaces.ThirdBean;
import org.springframework.stereotype.Service;

@Service
public class ThirdBeanImpl implements ThirdBean {
    @Override
    public String getData() {
        return "Zhansaya";
    }

    @Override
    public void setdata(String data) {
    }
}
