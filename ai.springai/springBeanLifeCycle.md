   BeanFactoryPostProcessor                 InstantiationAwareBeanPostProcessor             Bean                        Aware Interfaces
   -------------------------                -------------------------------------           -----------------------     -----------------
   postProcessBeanFactory()   ──────────────────────────────────────────────────────────────↓                                   
                                            postProcessBeforeInstantiation() ───────────────↓
                                                                                            ↓
                                                                                            Constructor called
                                                                                            ↓
                                                                                            Dependencies injected
                                            postProcessProperties() ─────────────────────── ↓
                                                                                                                  ↓─────↓
                                                                                                                        BeanNameAware.setBeanName()
                                                                                                                        ↓
                                                                                                                        BeanFactoryAware.setBeanFactory()
                                                                                                                        ↓
                                                                                                                        ApplicationContextAware.setAppCtx()
                                                                                                                  ↓─────↓
   BeanPostProcessor
   -----------------
   postProcessBeforeInit()   ────────────────────────────────────────────────────────────── ↓          
                                                                                            ↓
                                                                                            @PostConstruct
                                                                                            ↓
                                                                                            afterPropertiesSet()
                                                                                            ↓
                                                                                            custom init-method
                                                                                            ↓
   postProcessAfterInit()    ────────────────────────────────────────────────────────────── ↓
                                                                                            ↓
                                                                                            Bean is ready to use
                                                                                            ↓
                                                                                            @PreDestroy
                                                                                            ↓
                                                                                            destroy()
                                                                                            ↓
                                                                                            custom destroy-method
