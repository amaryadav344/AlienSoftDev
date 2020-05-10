package com.business.core.Event;

import com.business.core.Cache.MetaDataCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitApplicationEvent implements ApplicationListener<ApplicationReadyEvent> {
    private MetaDataCache metaDataCache;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        metaDataCache.LoadCache();
    }

    @Autowired
    public void setMetaDataCache(MetaDataCache metaDataCache) {
        this.metaDataCache = metaDataCache;
    }
}
