<template>
  <div>
    <n-data-table
      :bordered="false"
      :single-line="false"
      :columns="columns"
      :data="data"
      :pagination="pagination"
    />
    <BookDetails :active="modalActive" :book="bookRef" v-on:handle-hide-modal="handleHideModal" />
  </div>
</template>

<script setup lang="ts">

import { h, ref } from 'vue'
import { NTag, NButton, NDataTable } from 'naive-ui'
import type { DataTableColumns } from 'naive-ui'
import BookDetails from "./BookDetails.vue"

type RowData = {
  key: number
  name: string
  age: number
  address: string
  tags: string[]
}

const modalActive = ref<boolean>(false);

const handleHideModal = () => {
  modalActive.value = false;
}

const bookRef = ref<RowData | null>(null);

const createColumns = (
  {
  getDetails
  }: {
  getDetails: (rowData: RowData) => void
  }): DataTableColumns<RowData> => {
  return [
    {
      title: 'Name',
      key: 'name'
    },
    {
      title: 'Age',
      key: 'age'
    },
    {
      title: 'Address',
      key: 'address'
    },
    {
      title: 'Tags',
      key: 'tags',
      render (row) {
        const tags = row.tags.map((tagKey) => {
          return h(
            NTag,
            {
              style: {
                marginRight: '6px'
              },
              type: 'info',
              bordered: false
            },
            {
              default: () => tagKey
            }
          )
        })
        return tags
      }
    },
    {
      title: 'Action',
      key: 'actions',
      render (row) {
        return h(
          NButton,
          {
            size: 'small',
            onClick: () => getDetails(row)
          },
          { default: () => 'Get Details' }
        )
      }
    }
  ]
}

const createData = (): RowData[] => [
  {
    key: 0,
    name: 'John Brown',
    age: 32,
    address: 'New York No. 1 Lake Park',
    tags: ['nice', 'developer']
  },
  {
    key: 1,
    name: 'Jim Green',
    age: 42,
    address: 'London No. 1 Lake Park',
    tags: ['wow']
  },
  {
    key: 2,
    name: 'Joe Black',
    age: 32,
    address: 'Sidney No. 1 Lake Park',
    tags: ['cool', 'teacher']
  }
]
// const message = useMessage();
const data = createData();
const columns = createColumns({
  getDetails (rowData) {
      modalActive.value = true;
      bookRef.value = rowData;
    }
  })
const pagination = {
        pageSize: 10
      }
</script>