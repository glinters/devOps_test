<template>
    <n-modal
      :show="active"
      preset="dialog"
      title="Book details"
      negative-text="Close"
      @close="handleCloseModal"
      @negative-click="handleCloseModal"
      style="width: 1000px"
    >
        {{ book }}
    </n-modal>
  </template>
  
  <script setup lang="ts">
  import {
    NModal,
  } from "naive-ui";
  
  const emit = defineEmits<{
    (e: "handleHideModal", handleHideModal: boolean): void;
  }>();

  const handleCloseModal = () => {
    emit("handleHideModal", false);
  }

  defineProps<{
      active: boolean;
      book: any;
  }>();
  </script>
  