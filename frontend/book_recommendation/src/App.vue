<script setup lang="ts">
import LandingPage from './components/LandingPage.vue'
import {
  darkTheme,
  NConfigProvider,
  NMessageProvider,
  NNotificationProvider,
  NDialogProvider,
  NGlobalStyle
} from "naive-ui";
</script>

<template>
  <n-config-provider :theme="darkTheme">
    <n-global-style />
    <n-message-provider>
    <n-notification-provider>
      <n-dialog-provider>
        <LandingPage/>
      </n-dialog-provider>
    </n-notification-provider>
  </n-message-provider>
    
  </n-config-provider>
  
</template>
