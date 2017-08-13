package sql;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Created by neerbans on 13/8/17.
 */
public class CustomPageRequest implements Pageable {

    private int start = 0;
    private int limit = 0;
    private Sort sort;

    public CustomPageRequest(int start, int limit, Sort sort) {
        this.start = start;
        this.limit = limit;
        this.sort = sort;
    }

    @Override
    public int getPageNumber() {
        return 0;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public int getOffset() {
        return start;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return this;
    }

    @Override
    public Pageable first() {
        return this;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
