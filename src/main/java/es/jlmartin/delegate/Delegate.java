package es.jlmartin.delegate;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Delegate<Key, I>
{
    /** Logger. */
    private static final Logger LOG = Logger.getLogger(Delegate.class.getName());

    /** Value Map. */
    private Map<Key, I> map = new HashMap<Key, I>();


    /**
     *
     */
    public I getDelegate(Key key)
    {
        if (key == null)
        {
            LOG.warning("Key is null, ignoring delegating ");
            return null;
        }

        return map.get(key);
    }


    /**
     * @param map the map to set
     */
    public void setMap(Map<Key, I> map)
    {
        this.map = map;
    }
}

