package ua.bogdan_mikhalchenko.mvp_stepbystep.presenter.vo;

import java.io.Serializable;

/**
 * Created by Shipohvost on 12.05.2017.
 */

public class Branch implements Serializable {
    private String name;

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Branch branch = (Branch) o;

        return !(name != null ? !name.equals(branch.name) : branch.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}